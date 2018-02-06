package template;

import git.GitCloner;
import org.junit.*;
import system.CommandRunner;
import util.Constants;
import util.FileUtil;
import util.TestConstants;

import java.io.File;

import static util.TestConstants.TEST_ORG;
import static util.TestConstants.TEST_REPO;

/**
 * Created by matanghao1 on 6/2/18.
 */
public class GitTemplate {
    @BeforeClass
    public static void beforeClass(){
        deleteRepos();
        GitCloner.downloadRepo(TEST_ORG, TEST_REPO,"master");
    }

    @AfterClass
    public static void afterClass(){
        deleteRepos();
    }

    @After
    public void after(){
        CommandRunner.checkOut(TestConstants.LOCAL_TEST_REPO_ADDRESS,"master");
    }

    private static void deleteRepos(){
        FileUtil.deleteDirectory(Constants.REPOS_ADDRESS);
    }

}
