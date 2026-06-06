def call(String project, String imageTag, String dockerhubuser) {

    withCredentials([usernamePassword(
        credentialsId: 'jenkins-password',
        usernameVariable: 'dockerHubUser',
        passwordVariable: 'dockerHubPass'
    )]) {

        sh '''
            docker login -u $dockerHubUser -p $dockerHubPass
        '''

        sh """
            docker image tag ${project}:latest ${dockerhubuser}/${project}:${imageTag}
            docker push ${dockerhubuser}/${project}:${imageTag}
        """
    }
}
