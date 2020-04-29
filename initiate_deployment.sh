#!/bin/bash
COMMIT_ID=$1
SEM_VER=$2
ENV_NAME=$3

d=$(date +%Y-%m-%d)

cat  << EOF > payload.json
{
  "after": "${COMMIT_ID}",
  "ref": "refs/heads/develop",
  "env": "${ENV_NAME}",
  "teamEnv": "tvstack01-${ENV_NAME}",
  "version": "${SEM_VER}",
  "deployBy": "daily cronjob",
  "deployDate": "${d}"
}
EOF

echo "Running brig with commit id: ${COMMIT_ID}"
./brig run tvstack/dan-tvstack-bdd -n tvstack01 -e deploy -p payload.json -r master -c "${COMMIT_ID}"