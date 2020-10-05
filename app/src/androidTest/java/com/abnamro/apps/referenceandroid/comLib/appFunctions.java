package com.abnamro.apps.referenceandroid.comLib;

//importing all necessary classes and libraries required for app related common functions

import com.abnamro.apps.referenceandroid.objectRepository.homeScreenObjects;

import android.widget.TextView;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.AllOf.allOf;

public class appFunctions {

    //creating object of homeScreenObject class which can be used in verification
    private homeScreenObjects pageObject = new homeScreenObjects();

    public void verifyHomeScreenBody() {

        //Verifying that text Hello World is displayed on Home Screen

        onView(allOf(instanceOf(TextView.class), withParent(pageObject.homeScreen)))
                .check(matches(isDisplayed()))
                .check(matches(withText(pageObject.bodyText)));
    }

    //Verifying toolbar is displayed with screen title "ReferenceAndroid"
    public void verifyToolBar() {
        //verifying that toolbar is displayed
        onView(allOf(instanceOf(TextView.class), withParent(pageObject.toolBar)))
                .check(matches(isDisplayed()))
                .check(matches(pageObject.screenTitle));

    }

    //Verifying More Options is displayed
    public void verifyMenuBar() {
        onView(pageObject.menuButton)
                .check(matches(isDisplayed()));
    }

    //Verifying popup/submenu is displayed with text "Settings"
    public void verifySubMenu() {
        //Before clicking on More Options
        onView(pageObject.menuBar).check(doesNotExist());

        onView(pageObject.menuButton).perform(click());

        //After clicking on More Options
        onView(pageObject.menuBar).check(matches(isDisplayed()));
        onView(pageObject.subMenuTitle).check(matches(isDisplayed()))
                .check(matches(withText(pageObject.menuTitleText)));
    }

    //Verifying that mail button is displayed on home screen
    public void verifyMailButton() {

        onView(pageObject.mailButton).check(matches(isDisplayed()))
                .check(matches(isClickable()))
                .check(matches(isEnabled()));

    }

    //verifying snack bar
    public void verifySnackBar() {
        //Before clicking on mail button
        onView(pageObject.snackBar).check((doesNotExist()));

        onView(pageObject.mailButton).perform(click());

        //After clicking on mail button
        onView(pageObject.snackBar)
                .check(matches(isDisplayed()))
                .check(matches(withText(pageObject.msgText)));
    }

    //Verifying navigation bar is displayed on Home Screen
    public void verifyNavigationBar() {
        onView(pageObject.navBar)
                .check(matches(isDisplayed()));
    }

    //Verifying status bar is displayed on Home Screen
    public void verifyStatusBar() {
        onView(pageObject.statusBar)
                .check(matches(isDisplayed()));
    }

}
