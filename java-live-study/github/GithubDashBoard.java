package github.dashboard;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.*;

public class GithubDashBoard {
    private GitHub gitHub;
    private GHRepository repo;

    public GithubDashBoard(String repoName) throws IOException {
        this.gitHub = GitHubBuilder.fromPropertyFile("src/main/resources/application.properties").build();
        this.repo = this.gitHub.getRepository(repoName);
    }

    private List<GHIssue> getIssue() throws IOException {
        return this.repo.getIssues(GHIssueState.ALL);
    }

    private List<GHIssueComment> getComment(GHIssue issue) throws IOException {
        return issue.getComments();
    }

    private GHUser getUser(GHIssueComment comment) throws IOException {
        return comment.getUser();
    }

    private List<GHLabel> getLable(GHIssue issue){
        return (List<GHLabel>) issue.getLabels();
    }

    private Map<String,Double> getParticipation(List<GHIssue> issues) throws IOException {
        double issueCount = issues.size();
        Map<String, Set<Integer>> issueParticipation = new HashMap<>();
        Map<String,Double> per = new HashMap<>();

        for(GHIssue issue:issues){
            //과제만 필터링 하기 위한 파트
            boolean flag = false;
            for(GHLabel label: getLable(issue)){
                if (label.getName().equals("과제")) {
                    flag = true;
                }
            }
            if (!flag){
                issueCount-=1;
                continue;
            }

            for (GHIssueComment comment:getComment(issue)){
                String userName = getUser(comment).getLogin();//login은 닉네임 getName은 리얼 네임을 리턴
                if(userName.equals("whiteship")){
                    continue;
                }

                Integer issueNum = issue.getNumber();
                if(!issueParticipation.containsKey(userName)){
                    issueParticipation.put(userName,new HashSet<Integer>(Arrays.asList(issueNum)));
                }
                else{
                    issueParticipation.get(userName).add(issueNum);
                }
            }
        }

        for(String name: issueParticipation.keySet()){
            per.put(name,(double)((issueParticipation.get(name).size()*100)/issueCount));
        }

        return per;
    }

    public void displayDashBoard() throws IOException {
        List<GHIssue> issues = getIssue();
        Map<String, Double> per = getParticipation(issues);

        for (String name: per.keySet()) {
            System.out.println(name + " "+ String.format("%.2f", per.get(name)));
        }
    }

    public static void main(String[] args) throws IOException {
        GithubDashBoard git = new GithubDashBoard("whiteship/live-study");
        git.displayDashBoard();
    }

}
