package com.abnamro.apps.referenceandroid.test;

//importing necessary classes and libraries for building Home Screen test scenarios


import androidx.test.espresso.AmbiguousViewMatcherException;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

import com.abnamro.apps.referenceandroid.MainActivity;
import com.abnamro.apps.referenceandroid.comLib.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
//this class  includes test scenarios for ReferenceAndroid application
//this class is inherited from class appFunctions
public class homeScreenTestScenarios extends appFunctions {

    //creating object of config class
    private config configVar = new config();

    //Defining Activity Rule
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    private Activity activity;

    @Before
    //This method will setup screen orientation as mentioned config variables before executing test scenarios
    //This method will execute before each test method
    public void setUp() throws InterruptedException {

        //setting up device orientation to landscape/portrait
        if (configVar.device_mode.toString().equalsIgnoreCase("PORTRAIT")) {
            mActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else if (configVar.device_mode.toString().equalsIgnoreCase("LANDSCAPE")) {
            mActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        Thread.sleep(1000);

        //Launching activity under test...this will be executed before each test method
        mActivityTestRule.launchActivity(new Intent());
        activity = mActivityTestRule.getActivity();

    }

    //Test scenario for verifying Home Screen
    @Test
    public void verifyHomeScreen() throws InterruptedException {
        //verifying that text Hello World is displayed on Home Screen
        try {
            Thread.sleep(1000);
            verifyHomeScreenBody();
            verifyToolBar();
            verifyMenuBar();
            verifyNavigationBar();
            verifyStatusBar();
        } catch (InterruptedException | NoMatchingViewException | AmbiguousViewMatcherException e) {
            e.printStackTrace();
        }
    }

    //Test scenario for verifying functionality of Popup/sub menu
    @Test
    public void verifyPopUpMenu() throws InterruptedException {
        try {

            Thread.sleep(1000);
            verifyMenuBar();
            verifySubMenu();
        } catch (InterruptedException | NoMatchingViewException | AmbiguousViewMatcherException e) {
            e.printStackTrace();
        }
    }

    //Test scenario for verifying functionality of mail button and snack bar
    @Test
    public void verifyMailButtonAndSnackBar() throws InterruptedException {
        try {
            Thread.sleep(1000);
            verifyMailButton();
            verifySnackBar();
        } catch (InterruptedException | NoMatchingViewException | AmbiguousViewMatcherException e) {
            e.printStackTrace();
        }

    }

    //This method will execute after each test method
    @After
    public void tearDown() {
        //finishing activity launched for each test method
        mActivityTestRule.finishActivity();
    }

}