import io.ex.Example
import io.ex.Example2

def job_enable = "${LEI_MIGRATION}".toBoolean()

Example.run(this)
Example2.run(this)
