def migration = "${LEI_MIGRATION}".toBoolean();

this.pipelineJob('example') {
    environmentVariables {

    }
    parameters {

    }
    properties {

    }
    triggers {

    }
    throttleConcurrentBuilds {

    }
    logRotator {
        numToKeep(30)
    }
    disabled()
}
