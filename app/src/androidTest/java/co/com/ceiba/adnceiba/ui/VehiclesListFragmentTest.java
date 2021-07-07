package co.com.ceiba.adnceiba.ui;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.com.ceiba.adnceiba.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class VehiclesListFragmentTest {

    public static ViewAction clickChildViewWithId(final int id){
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public void perform(UiController uiController, View view) {
                View v = view.findViewById(id);
                v.performClick();
            }
        };
    }

    @Rule
    public ActivityScenarioRule<MainMenuActivity> mActivityTestRule = new ActivityScenarioRule<>(MainMenuActivity.class);

    @Test
    public void pay_corectClcik_true(){
        onView(withId(R.id.buttonViewVehicle)).perform(click());
        onView(ViewMatchers.withId(R.id.recyclerViewVehicles))
                .perform(RecyclerViewActions
                .actionOnItemAtPosition(0,clickChildViewWithId(R.id.buttonPay)));
        onView(withText(startsWith("El total a pagar por el vehiculo es")))
                .inRoot(isDialog()).check(matches(isDisplayed()));
        onView(withText(R.string.pay)).perform(click());
    }
}