#!/bin/bash
APP_NAME=$1
TEST_TYPE=$2

if [ "$TEST_TYPE" = "full" -a "$APP_NAME" = "dan-tvstack-ui" ]; then mvn clean verify -Dcucumber.options="src/test/resources/features/web" -Denv=$ENV_NAME; test_result=$?
elif [ "$TEST_TYPE" = "full" -a "$APP_NAME" = "dan-tvstack-service" ]; then mvn clean verify -Dcucumber.options="src/test/resources/features/api" -Denv=$ENV_NAME; test_result=$?
elif [ "$TEST_TYPE" = "sanity" -a "$APP_NAME" = "dan-tvstack-ui" ]; then mvn clean verify -Dcucumber.options="src/test/resources/features/web --tags @sanity" -Denv=$ENV_NAME; test_result=$?
elif [ "$TEST_TYPE" = "sanity" -a "$APP_NAME" = "dan-tvstack-service" ]; then mvn clean verify -Dcucumber.options="src/test/resources/features/api --tags @sanity" -Denv=$ENV_NAME; test_result=$?
fi

echo "Uploading results to $STORAGE_CONTAINER_URL/$APP_NAME/$TEST_TYPE"
./azcopy login --service-principal --application-id $AZCOPY_SPA_CLIENT_ID --tenant-id $AZCOPY_SPA_TENANT_ID
./azcopy copy ./target/cucumber-html-reports $STORAGE_CONTAINER_URL/$ENV_NAME/$APP_NAME/$TEST_TYPE --recursive=true

exit $test_result
az login --service-principal -u '899aaed2-a4f1-46e0-8030-e6a91adb0c8c' -p '9aa4afc8-5c0b-4b80-8adc-802b329e9822' --tenant '6e8992ec-76d5-4ea5-8eae-b0c5e558749a'
az storage blob upload-batch --account-name gdpclientsaacc -s ./target/cucumber-html-reports -d gdpclient01-bdd-results/$ENV_NAME/$APP_NAME/$TEST_TYPE --subscription 968853fd-f3eb-4840-a1ee-536cfdea8092