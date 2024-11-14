package codec.types.field46.field1.types

import codec.FieldCodecs.{AN, LLVAR}
import codec.types.field46.field1.TokenData4601XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.codecs.mappedEnum
import scodec.{Codec, TransformSyntax}

case class SchemeNetworkDecision460106(
    decisionStatus: SchemeNetworkDecision460106.DecisionStatus
) extends TokenData4601XX

object SchemeNetworkDecision460106 {
  sealed abstract class DecisionStatus(val value: String)
      extends StringEnumEntry

  object DecisionStatus extends StringEnum[DecisionStatus] {
    val values: IndexedSeq[DecisionStatus] = findValues

    case object OK extends DecisionStatus("01")
    case object KO extends DecisionStatus("02")
    case object OTP extends DecisionStatus("03")

    val mapping: Map[DecisionStatus, String] =
      DecisionStatus.valuesToEntriesMap.map(_.swap)
  }
  val codec: Codec[SchemeNetworkDecision460106] = LLVAR(
    mappedEnum(AN, DecisionStatus.mapping)
  ).as[SchemeNetworkDecision460106]
}
