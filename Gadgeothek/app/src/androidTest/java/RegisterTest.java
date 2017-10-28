import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.hsr.mge.gadgeothek.R;
import ch.hsr.mge.gadgeothek.ui.RegisterActivity;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by dhug on 10/21/2017.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegisterTest {
    @Rule
    public ActivityTestRule<RegisterActivity> activityTestRule = new ActivityTestRule<>(RegisterActivity.class);

    @Test
    public void showsRegisterActivity() {
        Espresso.onView(withId(R.id.registerButton)).check(matches(isDisplayed()));
    }

    @Test
    public void registrationSuccessfull() {
        Espresso.onView(withId(R.id.name)).perform(typeText("Dominik"));
        Espresso.onView(withId(R.id.email)).perform(typeText("dhug@dominikhug.ch"));
        Espresso.onView(withId(R.id.matrikelnr)).perform(typeText("123456"));
        Espresso.onView(withId(R.id.password)).perform(typeText("topSecret"));
        Espresso.onView(withId(R.id.registerButton)).perform(click());
    }
}
