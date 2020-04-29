const devops = require("devops-brigade");

devops.Events.onPushDevelop(async () => {
  await devops.Utilities.gitVersionAsync();
  await devops.Standard.packageAsync({ noBuild: true });
  await devops.Standard.approveAsync();
  await new devops.ApprovalJobFactory(e, project).tagVersionAsLatest();
});