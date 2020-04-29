package PMS.utilities;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class MongoDbConnection {


    private static final Logger log = LoggerFactory.getLogger(MongoDbConnection.class);

    MongoClientURI uri = null;
    MongoClient mongoClient = null;
    MongoDatabase database = null;
    MongoCollection<Document> projectChannelCollection,clientsCollection, marketsCollection, phasingCollection, projectsCollection, audiencesCollection, surveysCollection, scenariosCollection, buyingAudiencesCollection, countriesCollection;
    String projectChannelId;
    private MongoCollection<Document> formatsCollection,campaignLengthsCollection;

    public void connect() {
        //AWS mongo dev
        //uri = new MongoClientURI("mongodb://admin:admin@ec2-35-176-240-97.eu-west-2.compute.amazonaws.com:27017/?authSource=tvstack");

        //Kubernetes mongo DEV
        uri = new MongoClientURI("mongodb://tvstack01-dev:fsdfasdJJKHJHK@tvstack01-dev-mdb-mongodb.tvstack01-dev.svc.cluster.local:27017/?authSource=tvstack");
        mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase("tvstack");
        log.info("Connected to database");
    }


    //Fetching client documents
    public MongoCollection queryClients() {
        log.info("******************************** Clients ************************************************");
        clientsCollection = database.getCollection("Clients");
        System.out.println("Clients  : " + clientsCollection.count());
        return clientsCollection;
    }

    public Document getClientById(String clientId) {
        log.info("******************************** Client ************************************************");
        clientsCollection = database.getCollection("Clients");
        Document clientDetails = clientsCollection.find(eq("_id",clientId)).first();
       // Document clientDetail = clientsCollection.find(eq("_id", clientId)).first();
        return clientDetails;
        }

    public void fetchClients() {
        List<Document> clients = clientsCollection.find().into(new ArrayList<Document>());
        for (Document client : clients) {
            System.out.println("Name : " + client.get("name") + "         Market Id : " + client.get("marketId") + "       Country : " + client.get("country"));
        }
    }


    //Fetching market documents
    public MongoCollection queryMarkets() {
        log.info("******************************** Markets ************************************************");
        marketsCollection = database.getCollection("Markets");
        System.out.println("Markets  : " + marketsCollection.count());
        return marketsCollection;
    }

    public void fetchMarkets() {
        List<Document> markets = marketsCollection.find().into(new ArrayList<Document>());
        for (Document market : markets) {
            System.out.println("_id : " + market.get("_id") + " name : " + market.get("name"));

            List<Document> campaignLengths = (List<Document>) market.get("campaignLengths");
            for (Document campaignLength : campaignLengths) {
                System.out.println("CampaignLengthId : " + campaignLength.get("campaignLengthId"));
                System.out.println("Name  : " + campaignLength.get("name"));

            }
        }
    }

    //Fetching project documents
    public MongoCollection queryProjects() {
        log.info("******************************** Projects ************************************************");
        projectsCollection = database.getCollection("Projects");
        System.out.println("Projects : " + projectsCollection.count());
        return projectsCollection;
    }
    //Fetching Phases from db
    public MongoCollection queryPhasing(){
        log.info("******************************** Projects ************************************************");
        phasingCollection = database.getCollection("Phasing");
        System.out.println("Phases : " + phasingCollection.count());
        return phasingCollection;
    }

    public Document fetchPhaseBykey(String phaseKey){
        Document phaseDoc = phasingCollection.find(eq("phasingKey",phaseKey)).first();
        return phaseDoc;
    }

    public Document fetchPhaseByProjectId(String projectId){
        Document phaseDoc = phasingCollection.find(eq("projectId",projectId)).first();
       // String phase = (String) phaseDoc.get("projectId");
        return phaseDoc;
    }

    public Document fetchProjectById(String id) {
        Document project = projectsCollection.find(eq("_id", id)).first();
        return project;
    }

    public Document fetchProjectByName(String name) {
        Document project = projectsCollection.find(eq("name", name)).first();
        return project;
    }

    public Document fetchScenarioByName(String name) {
        Document scenario = scenariosCollection.find(eq("name", name)).first();
        return scenario;
    }

    //Fetch audience by name
    public String fetchAudienceByName(String name) {
        Document audienceDoc = audiencesCollection.find(eq("name", name)).first();
        String audience = (String) audienceDoc.get("name");
        return audience;
    }

    //Fetching Audiences documents
    public MongoCollection queryAudiences(Bson name) {
        log.info("******************************** Audiences ************************************************");
        audiencesCollection = database.getCollection("Audiences");
        System.out.println("Audiences : " + audiencesCollection.count());
        audiencesCollection.find(eq("name", name));
        return audiencesCollection;
    }

    //Fetching Project channels
    public MongoCollection queryProjectChannels() {
        log.info("******************************** Project channels ************************************************");
        projectChannelCollection = database.getCollection("ProjectChannels");

       return  projectChannelCollection;

    }



    //Fetching Surveys documents
    public MongoCollection querySurveys() {
        log.info("******************************** Surveys ************************************************");
        surveysCollection = database.getCollection("Surveys");
        System.out.println("Surveys : " + surveysCollection.count());
        return surveysCollection;
    }

    //Fetching ﻿Scenarios documents
    public MongoCollection queryScenarios() {
        log.info("******************************** Scenarios ************************************************");
        scenariosCollection = database.getCollection("Scenarios");
        System.out.println("Scenarios : " + scenariosCollection.count());
        return scenariosCollection;
    }
    public MongoCollection fetchScenarioIdbyName(){
        scenariosCollection = database.getCollection("Scenarios");
      //  Document ScenarioDetails = scenariosCollection.find(eq(scenarioName));

        MongoCollection scenarioId = null;
        return scenarioId;
    }

    public String fetchPlAudienceId() {
        projectsCollection = database.getCollection("Projects");
        //  Document project = projectsCollection.find();
        String PlAudienceId = String.valueOf(projectsCollection.find(eq("plAudienceId")));
        // Bson PlAudienceId = projectsCollection.find(eq("plAudienceId"));
        System.out.println(PlAudienceId);
        return PlAudienceId;
    }


    //Fetching ﻿BuyingAudiences documents
    public MongoCollection queryBuyingAudiences() {
        log.info("******************************** BuyingAudiences ************************************************");
        buyingAudiencesCollection = database.getCollection("BuyingAudiences");
        System.out.println("BuyingAudiences : " + buyingAudiencesCollection.count());
        return buyingAudiencesCollection;
    }

    //Fetching ﻿Countries documents
    public MongoCollection queryCountries() {
        log.info("******************************** Countries ************************************************");
        countriesCollection = database.getCollection("Countries");
        System.out.println("Countries : " + countriesCollection.count());
        return countriesCollection;
    }

    //Fetching Formats documents
    public MongoCollection queryFormats() {
        log.info("******************************** Formats ************************************************");
        formatsCollection = database.getCollection("Formats");
        System.out.println("Countries : " + formatsCollection.count());
        return formatsCollection;
    }

    //Fetching Campaign Lengths
    public MongoCollection queryCampaignLengths() {
        log.info("******************************** Campaign Lengths ************************************************");
        campaignLengthsCollection = database.getCollection("CampaignLengths");
        System.out.println("Campaign Lengths : " + campaignLengthsCollection.count());
        return campaignLengthsCollection;
    }

    public void disconnect() {
        mongoClient.close();
        log.info("Database connection closed");
    }

}
