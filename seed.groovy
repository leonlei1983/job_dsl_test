import io.ex.Example
import io.ex.Example2

def job_enable = "${job_enable}".toBoolean()

Example.run(this, job_enable)
Example2.run(this, job_enable)
