package github.dashboard;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kohsuke.github.GHIssue;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GithubDashBoardTest {

    @Test
    @SuppressWarnings("unchecked")
    void getParticipationTest() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        GithubDashBoard git = new GithubDashBoard("whiteship/live-study");
        Method issue = git.getClass().getDeclaredMethod("getIssue");
        issue.setAccessible(true);
        Method participation = git.getClass().getDeclaredMethod("getParticipation", List.class);
        participation.setAccessible(true);

        Map<String,Double> per = (Map<String, Double>) participation.invoke(git,issue.invoke(git));
        //List<GHIssue> issues = git.getIssue();
        //Map<String, Double> per = git.getParticipation(issues);

        Assertions.assertThat(String.format("%.2f",per.get("2yeseul"))).isEqualTo("86.67");
    }
}