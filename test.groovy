
def env = "${LEI_ENV}".toLowerCase();
def migration = "${LEI_MIGRATION ?: 'false'}".toBoolean();

