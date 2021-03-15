import scala.io.Source
import java.io._

object CSVReader extends App {
  
  val filename = "cars.csv"
  val bufferedSource = io.Source.fromFile(filename)
  val pw = new PrintWriter(new File("output.txt" ))


  for(line <- bufferedSource.getLines().drop(2)){
    val cols = line.split(";").map(_.trim)
    pw.write(s"${cols(0)} | ${cols(1)} | ${cols(4)} | ${cols(6)} | ${cols(8)} \n")
    
    
   
    
  }
  pw.close()
  bufferedSource.close()
  
}