package com.android.contacts;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import androidx.test.rule.ActivityTestRule;
import com.example.navigationtest.R;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.*;

public class ContactsTest {
    @Rule
    public ActivityTestRule<MyActivity> activityActivityTestRule = new ActivityTestRule<>(MyActivity.class);

    //@Rule
    //public IntentsTestRule<MyActivity> intentsTestRule = new IntentsTestRule<>(MyActivity.class, false, true);

   @Test
    public void clickButtonPlus() {
        onView(withText("Contacts"))
                .perform(click());
       intending(toPackage("com.android.contacts"));

        //onView(withId(R.id.floating_action_button))
                //.perform(click());

        onView(withText("First name"))
                .perform(typeText("Lana"), closeSoftKeyboard());

        onView(withText("Phone"))
                .perform(typeText("+79147256963"), closeSoftKeyboard());

        onView(withText("Save"))
                .perform(click())
                    .check(matches(isDisplayed()));
    }

    /*@Test
    public void activityResult_DisplaysContactsPhoneNumber() {
        // Build the result to return when the activity is launched.
        Intent resultData = new Intent();
        String phoneNumber = "123-345-6789";
        resultData.putExtra("phone", phoneNumber);
        Instrumentation.ActivityResult result =
                new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);

        // Set up result stubbing when an intent sent to "contacts" is seen.
        intending(toPackage("com.android.contacts")).respondWith(result);

        // User action that results in "contacts" activity being launched.
        // Launching activity expects phoneNumber to be returned and displayed.
        onView(withId(R.id.icon)).perform(click());

        // Assert that the data we set up above is shown.
        onView(withId(R.id.phoneNumber)).check(matches(withText(phoneNumber)));
    }*/


    }

