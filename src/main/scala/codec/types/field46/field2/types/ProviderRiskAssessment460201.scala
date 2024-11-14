package codec.types.field46.field2.types

import codec.FieldCodecs.{AN, LLVAR}
import codec.types.field46.field2.WalletData4602XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.codecs.mappedEnum
import scodec.{Codec, TransformSyntax}

case class ProviderRiskAssessment460201(
    decisionStatus: ProviderRiskAssessment460201.Status
) extends WalletData4602XX

object ProviderRiskAssessment460201 {
  sealed abstract class Status(val value: String) extends StringEnumEntry

  object Status extends StringEnum[Status] {
    val values: IndexedSeq[Status] = findValues

    case object OK extends Status("01")
    case object OTP extends Status("02")
    case object KO extends Status("03")

    val mapping: Map[Status, String] =
      Status.valuesToEntriesMap.map(_.swap)
  }
  val codec: Codec[ProviderRiskAssessment460201] = LLVAR(
    mappedEnum(AN, Status.mapping)
  ).as[ProviderRiskAssessment460201]
}
