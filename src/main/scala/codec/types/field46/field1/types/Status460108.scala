package codec.types.field46.field1.types

import codec.FieldCodecs.{AN, LLVAR}
import codec.types.TokenData4601XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.{Codec, TransformSyntax}
import scodec.codecs.mappedEnum

case class Status460108(status: Status460108.Status) extends TokenData4601XX

object Status460108 {
  sealed abstract class Status(val value: String) extends StringEnumEntry

  object DecisionStatus extends StringEnum[Status] {
    val values: IndexedSeq[Status] = findValues

    case object ACTIVE extends Status("01")
    case object INACTIVE extends Status("02")
    case object SUSPENDED extends Status("03")
    case object DESACTIVATED extends Status("04")

    val mapping: Map[Status, String] =
      DecisionStatus.valuesToEntriesMap.map(_.swap)
  }
  val codec: Codec[Status460108] = LLVAR(
    mappedEnum(AN, DecisionStatus.mapping)
  ).as[Status460108]
}

