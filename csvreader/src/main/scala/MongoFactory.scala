import org.mongodb.scala._
import org.mongodb.scala.bson.codecs.Macros._
import org.mongodb.scala.MongoClient.DEFAULT_CODEC_REGISTRY
import org.bson.codecs.configuration.CodecRegistries.{fromRegistries, fromProviders}
import org.mongodb.scala.bson.collection.immutable.Document
import org.mongodb.scala.model.Filters._


object MongoFactory {

    case class originPercentage(carName: String, mpg:  String, horsepower: String, origin: String)
    val providers = fromProviders(classOf[originPercentage])
    val registry = fromRegistries(providers, DEFAULT_CODEC_REGISTRY)
    val codeRegistry = fromRegistries(fromProviders(classOf[originPercentage]), DEFAULT_CODEC_REGISTRY)
    val mongoClient = MongoClient()

    val database = mongoClient.getDatabase("cars").withCodecRegistry(codeRegistry)

    def insertCar(data: originPercentage): Unit = {
      val collection: MongoCollection[originPercentage] = database.getCollection("myCollection")
      collection.insertOne(data).results()
    }
}