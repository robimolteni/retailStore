package test.retail.retailstore;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.mock;

/**
 * Created by robimolte on 21/04/2017.
 */

public class EspressoTest {


    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Rule
    // third parameter is set to false which means the activity is not started automatically
    public ActivityTestRule<ProductsActivity> rule =
            new ActivityTestRule(ProductsActivity.class, true, false);



    //very easy Espresso Test to check if activity has started checking if recycle view is displayed
    @Test
    public void startResultActivity() {
        Intent intent = new Intent();
        intent.putExtra("categorySelected","Electronics");
        rule.launchActivity(intent);
        onView(withId(R.id.recycler_view_products)).check(matches(isDisplayed()));

    }
}
