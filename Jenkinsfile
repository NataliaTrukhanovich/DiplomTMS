pipeline {
    agent any

    stages {
        stage('Git') {
            steps {
              git branch: 'main', credentialsId: '7b4bd90b-07a2-4e82-b1fd-d32a997add11', url: 'https://github.com/NataliaTrukhanovich/DiplomTMS.git'
            }
        }
         stage('Build'){
            steps{
                powershell 'mvn clean install -DskipTests'
            }
        }
        stage('Run'){
            steps{
                powershell 'mvn clean test -Dconfig=\'%CONFIG%\' -DsuiteXml=\'%SUITE%\''
            }
        }
    }
    post {
        always{
            archiveArtifacts artifacts: 'target/logs/*', allowEmptyArchive: true
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
        }
    }
}