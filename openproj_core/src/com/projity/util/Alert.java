/*
The contents of this file are subject to the Common Public Attribution License
Version 1.0 (the "License"); you may not use this file except in compliance with
the License. You may obtain a copy of the License at
http://www.projity.com/license . The License is based on the Mozilla Public
License Version 1.1 but Sections 14 and 15 have been added to cover use of
software over a computer network and provide for limited attribution for the
Original Developer. In addition, Exhibit A has been modified to be consistent
with Exhibit B.

Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
specific language governing rights and limitations under the License. The
Original Code is OpenProj. The Original Developer is the Initial Developer and
is Projity, Inc. All portions of the code written by Projity are Copyright (c)
2006, 2007. All Rights Reserved. Contributors Projity, Inc.

Alternatively, the contents of this file may be used under the terms of the
Projity End-User License Agreeement (the Projity License), in which case the
provisions of the Projity License are applicable instead of those above. If you
wish to allow use of your version of this file only under the terms of the
Projity License and not to allow others to use your version of this file under
the CPAL, indicate your decision by deleting the provisions above and replace
them with the notice and other provisions required by the Projity  License. If
you do not delete the provisions above, a recipient may use your version of this
file under either the CPAL or the Projity License.

[NOTE: The text of this license may differ slightly from the text of the notices
in Exhibits A and B of the license at http://www.projity.com/license. You should
use the latest text at http://www.projity.com/license for your modifications.
You may not remove this license text from the source files.]

Attribution Information: Attribution Copyright Notice: Copyright (c) 2006, 2007
Projity, Inc. Attribution Phrase (not exceeding 10 words): Powered by OpenProj,
an open source solution from Projity. Attribution URL: http://www.projity.com
Graphic Image as provided in the Covered Code as file:  openproj_logo.png with
alternatives listed on http://www.projity.com/logo

Display of Attribution Information is required in Larger Works which are defined
in the CPAL as a work which combines Covered Code or portions thereof with code
not governed by the terms of the CPAL. However, in addition to the other notice
obligations, all copies of the Covered Code in Executable and Source Code form
distributed must, as a form of attribution of the original author, include on
each user interface screen the "OpenProj" logo visible to all users.  The
OpenProj logo should be located horizontally aligned with the menu bar and left
justified on the top left of the screen adjacent to the File menu.  The logo
must be at least 100 x 25 pixels.  When users click on the "OpenProj" logo it
must direct them back to http://www.projity.com.
*/
package com.projity.util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.Set;
import java.util.prefs.Preferences;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.projity.strings.Messages;

/**
 *
 */
public class Alert {
	public static void warn(Object errorObject) {
		if (allowPopups())
			warn(errorObject,getFrame());
	}
	public static void warn(Object errorObject, Component parent) {
		System.out.println("warning message " + errorObject);

		if (allowPopups())
			JOptionPane.showMessageDialog(parent,errorObject, Messages.getContextString("Title.ProjityWarning"),JOptionPane.WARNING_MESSAGE);
	}

	public static void error(Object errorObject) {
		if (allowPopups())
			error(errorObject,getFrame());
	}
	public static void error(Object errorObject, Component parent) {
		System.out.println("error message " + errorObject);

		if (allowPopups())
			JOptionPane.showMessageDialog(parent,errorObject, Messages.getContextString("Title.ProjityError"),JOptionPane.ERROR_MESSAGE);
	}
	public static int confirmYesNo(Object messageObject) {
		if (!allowPopups())
			return JOptionPane.NO_OPTION;
		return JOptionPane.showConfirmDialog(getFrame(),
		        messageObject,
		        Messages.getContextString("Text.ApplicationTitle"),
	            JOptionPane.YES_NO_OPTION);
	}
	public static int confirm(Object messageObject) {
		if (!allowPopups())
			return JOptionPane.NO_OPTION;
		int result = JOptionPane.showConfirmDialog(getFrame(),
		        messageObject,
		        Messages.getContextString("Text.ApplicationTitle"),
	            JOptionPane.YES_NO_CANCEL_OPTION);
		if (result == JOptionPane.CLOSED_OPTION)
			result = JOptionPane.CANCEL_OPTION;
		return result;
	}
	public static boolean okCancel(Object messageObject) {
		if (!allowPopups())
			return true;

		return JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(getFrame(),
		        messageObject,
		        Messages.getContextString("Text.ApplicationTitle"),
	            JOptionPane.OK_CANCEL_OPTION);
	}

	public static String renameProject(final String name,Set projectNames,boolean saveAs){
		try {
			return (String)Class.forName(GRAPHIC_MANAGER).getMethod("doRenameProjectDialog",new Class[]{String.class,Set.class,boolean.class}).invoke(getGraphicManager(),new Object[]{name,projectNames,saveAs});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	private static final String GRAPHIC_MANAGER="com.projity.pm.graphic.frames.GraphicManager";
	public static Frame getFrame(){
		try {
		    return (Frame)Class.forName(GRAPHIC_MANAGER).getMethod("getFrameInstance",null).invoke(null,null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static Object getGraphicManager(){
		try {
		    return Class.forName(GRAPHIC_MANAGER).getMethod("getInstance",null).invoke(null,null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static boolean allowPopups() {
		return Environment.isClientSide() && !Environment.isBatchMode();
	}
	public static Object getGraphicManagerMethod(String method) {
		try {
			return Class.forName(GRAPHIC_MANAGER).getMethod(method,null).invoke(null,null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void setGraphicManagerMethod(String method,Object value) {
		try {
			Class.forName(GRAPHIC_MANAGER).getMethod(method,new Class[] {Object.class}).invoke(null,new Object[] {value});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void warnWithOnceOption(Object object,String preference) {
		warnWithOnceOption(object,preference,null);
	}
	public static void warnWithOnceOption(Object object,String preference,Component parentComponent) {
		boolean warned =  Preferences.userNodeForPackage(Alert.class).getBoolean(preference,false);
		if (warned)
			return;
		JOptionPane pane = new JOptionPane(object);
		String title=Messages.getContextString("Text.ApplicationTitle");
		JDialog dialog = pane.createDialog(parentComponent,title);
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		JCheckBox notAgain = new JCheckBox(Messages.getString("Text.doNotShowAgain"));
		p.add(notAgain);
		pane.add(p);
		Dimension d=dialog.getSize();
		d.height+=40; // for extra height of checkbox
		dialog.setSize(d);
		dialog.setVisible(true);
		if (notAgain.isSelected())
			Preferences.userNodeForPackage(Alert.class).putBoolean(preference,true);


	}

}
