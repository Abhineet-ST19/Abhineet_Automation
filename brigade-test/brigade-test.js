const { logJob } = require('./mock-brigadier')

// Workaround for loading brigade.js from this folder so it can import 
// devops-brigade. Must do this synchronously so it's available by the next line
// that imports it.
var fs = require('fs-extra');
fs.copySync('../brigade.js', 'brigade.js');

const { JobFactory, deploy } = require("./brigade")

function testJobs() {    
    const e = {
        revision: {
            commit: 'deadbeefdeadbeefdeadbeefdeadbeef',
            ref: 'develop'
        },
        payload: JSON.stringify({
            after: 'deadbeefdeadbeefdeadbeefdeadbeef',
            ref:'/ref/heads/develop',
            env: 'dev',
            version: '1.0.1'
        })
    };

    const project = {
        secrets: {
            base: 'devops',
            team_name: 'my-team',
            app_name: 'my-app',
            app_container_reg: 'myreg11.azurecr.io',
            global_container_reg: 'globaldevopsreg11.azurecr.io',
            "yourteam01-dev_resource_group": "devops-aks-rg",
            "yourteam01-dev_cluster": "my-aks-cluster",
            "yourteam01-dev_cluster_type": "aks",
            "yourteam01-dev_okta_password": "MY OKTA PASSWORD",
            
            azure_client_id: "my-az-client-id",
            azure_client_secret: "my-az-client-secret",
            azure_tenant_id: "my-az-tenant-id"
        },
        repo: { 
            name: 'devops/release-management',
            cloneURL: 'https://gitea-tooling.az.globaldevops.gdpdentsu.netglobal/devops/brigade-boilerplate.git'            
        },
        kubernetes: {
            namespace: 'my-namespace'
        }
    };

    let factory = new JobFactory();
    logJob(factory.createDeployJob("yourteam01-dev", e, project, "1.2.3", { sanityOnly: true }));
    logJob(factory.createIntegrationTestDeps(e, project));
    factory.createIntegrationTestJobs("yourteam01-dev", e, project).forEach(j => logJob(j));
    logJob(factory.createUploadResultsJob("yourteam01-dev", e, project));
    deploy(e, project, "yourteam01-dev", "1.2.3", {sanityOnly: true});
}

testJobs();
