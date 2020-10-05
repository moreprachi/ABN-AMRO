package com.abnamro.apps.referenceandroid.objectRepository;

import com.abnamro.apps.referenceandroid.R;

import org.hamcrest.Matcher;

import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

//This class has all necessary objects present on screen and variables needed for testing
public class homeScreenObjects {
    //Global variables : strings used while identifying objects withText or verifying object text
    public static final String bodyText = "Hello World!";
    public static final String titleText = "ReferenceAndroid";
    public static final String menuDescription = "More options";
    public static final String msgText = "Replace with your own action";
    public static final String menuTitleText = "Settings";

    //Home screen objects
    //below properties are captured using Layout Inspector tool of Android Studio for identifying objects uniquely
    public Matcher homeScreen = withId(R.id.fragment);
    public Matcher toolBar = withId(R.id.toolbar);
    public Matcher screenTitle = withText(titleText);
    public Matcher menuButton = withContentDescription(menuDescription);
    public Matcher menuBar = withId(R.id.content);
    public Matcher subMenuTitle = withId(R.id.title);
    public Matcher mailButton = withId(R.id.fab);
    public Matcher snackBar = withId(R.id.snackbar_text);
    public Matcher navBar = withId(android.R.id.navigationBarBackground);
    public Matcher statusBar = withId(android.R.id.statusBarBackground);
}
