import java.io.FileReader
import java.util.{Date, HashMap}
import instruction.impl.InstructionList

//class Main (var instructionList: InstructionList) {
//
//  private val hm: HashMap[String, AnyRef] = new HashMap[String, AnyRef]
//
//  def exec = instructionList.run(hm)
//
//  def main(args: Array[String]): Unit = {
//    try {
//      var p: Parser = null
//      if (args.length != 0) p = new Parser(new Lexer(new FileReader(args(0))))
//      else {
//        System.out.printf("Paiton 1.0.5 | Virtual Envaironment | (default %s)\n", new Date().toString)
//        System.out.println("[GCC 4.2.1 Compatible Clang 4.0.1 (tags/RELEASE_401/final)] on darwin")
//        System.out.println("Type \"read\" to read, \"write\" to print, or \"end\" to finish.")
//        p = new Parser(new Lexer(new Interpreter))
//      }
//      val result = p.parse.value
//    } catch {
//      case e: Exception =>
//        e.printStackTrace()
//    }
//  }
//}