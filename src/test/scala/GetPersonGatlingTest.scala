import io.gatling.core.Predef._
import io.gatling.http.Predef._

class GetPersonGatlingTest extends Simulation {
  val httpProtocol = http.baseURL(s"http://localhost:8080")

  val scn = scenario("RestSimulation")
    .exec(http("hello").get("/persons"))

  setUp(scn.inject(atOnceUsers(100))).protocols(httpProtocol)
}
