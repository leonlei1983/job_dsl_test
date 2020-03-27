
def env = "${LEI_ENV}".toLowerCase();
def migration = "${LEI_MIGRATION ?: 'false'}".toBoolean();

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
