def migration = "${LEI_MIGRATION}".toBoolean();

this.pipelineJob('example') {
    environmentVariables {

    }
    // parameters {

    // }
    properties {
        disableConcurrentBuilds()
    }
    triggers {
        githubPush()
    }
    triggers {
        upstream(pipeline.upstream)
    }
    // throttleConcurrentBuilds {

    // }
    logRotator {
        numToKeep(30)
    }
    disabled()
}
