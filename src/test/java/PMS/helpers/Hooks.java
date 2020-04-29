package PMS.helpers;

/*import PMS.services.ProjectsService;
import PMS.steps.api.AccessTokenSteps;
import PMS.utilities.AppliEyes;
import com.jayway.restassured.response.Response;
import cucumber.api.java.After;
import PMS.steps.api.ManageProjectSteps;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger log = LoggerFactory.getLogger(Hooks.class);
    private Object projectId;
  //  private Response deletePlanResponse;
   // public AppliEyes appliEyes;
    private String oktaAccessToken;
  //  AccessTokenSteps accessTokenSteps;

  /*  @After
    public void tearDown() {
        projectId = ManageProjectSteps.getProjectId();
        oktaAccessToken = AccessTokenSteps.getOktaAccessToken();

        if (projectId != null) {
            deletePlanResponse = ProjectsService.deleteProject(oktaAccessToken, projectId);
            log.info("Project Deleted");
        }*/

     //   appliEyes.tearDown();
    }

