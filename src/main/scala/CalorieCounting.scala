import scala.io.Source
import scala.language.postfixOps
import scala.util.Using

object CalorieCounting extends App {
  private val inputFilePath = "src/main/scala/input_day_one.in"
  private var x: Int = 10
  private var ans: Int = 0
  private var calorie_per_elf: List[Int] = List()

  for(line <- Source.fromFile(inputFilePath).getLines()) {
    if(line.nonEmpty){
      x += line.toInt
    } else {
      calorie_per_elf = calorie_per_elf.::(x)
      x = 0
    }
  }

  calorie_per_elf = calorie_per_elf.sortWith(_ > _)
  for(cal: Int <- calorie_per_elf.slice(0, 3)) {
    ans += cal
  }

  println("Part one Answer = ", calorie_per_elf.head)
  println("Part two Answer = ", ans)
}
