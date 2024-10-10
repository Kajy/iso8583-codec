package codec.types.field46.field4.`type`

import codec.FieldCodecs.{AN, LLVAR, N}
import codec.types.field46.field4.OtherData4604XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.Codec
import scodec.codecs._

case class CVX2Result460404(value: CVX2Result460404.Result)
    extends OtherData4604XX

object CVX2Result460404 {
  sealed abstract class Result(val value: String) extends StringEnumEntry

  object Result extends StringEnum[Result] {
    val values = findValues

    case object VALID extends Result("M")
    case object INVALID extends Result("N")
    case object NOT_PROCESSED extends Result("P")
    case object NOT_CHECKED extends Result("U")

    val mapping = Result.valuesToEntriesMap.map(_.swap)
    val codec = mappedEnum(AN, mapping)
  }
  val codec: Codec[CVX2Result460404] =
    LLVAR(Result.codec).as[CVX2Result460404]
}
