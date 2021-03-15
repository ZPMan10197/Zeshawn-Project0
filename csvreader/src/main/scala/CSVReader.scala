import scala.io.Source
import java.io._

object CSVReader extends App {
  
  val filename = "covid19.csv"
  val bufferedSource = io.Source.fromFile(filename)
  val pw = new PrintWriter(new File("output.txt" ))
  val pwExp = new PrintWriter(new File("exports.txt" ))
  val pwImp = new PrintWriter(new File("imports.txt" ))

  for(line <- bufferedSource.getLines().drop(1)){
    val cols = line.split(",").map(_.trim)
    var temp = cols(1).toInt
    if(temp > 2019 && cols(4) == "United States"){
      pw.write(s"${cols(0)}|${cols(1)}|${cols(4)}|${cols(5)}|${cols(9)} \n")
    }
    else if(cols(0) == "Exports"){
      pwExp.write(s"${cols(0)}|${cols(1)}|${cols(4)}|${cols(5)}|${cols(9)} \n")
    }
    else{
     pwImp.write(s"${cols(0)}|${cols(1)}|${cols(4)}|${cols(5)}|${cols(9)} \n")
    }
    
  }
  pwExp.close()
  pwImp.close()
  pw.close()
  bufferedSource.close()
  
}