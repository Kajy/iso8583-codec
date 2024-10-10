package codec.types.field46.field1.types

import codec.FieldCodecs.{AN, LLVAR}
import codec.types.TokenData4601XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.{Codec, TransformSyntax}
import scodec.codecs.mappedEnum

case class ActivationResultVerification460109(
    result: ActivationResultVerification460109.VerificationStatus
) extends TokenData4601XX

object ActivationResultVerification460109 {
  sealed abstract class VerificationStatus(val value: String)
      extends StringEnumEntry

  object VerificationStatus extends StringEnum[VerificationStatus] {
    val values: IndexedSeq[VerificationStatus] = findValues

    case object SUCCESS extends VerificationStatus("01")
    case object EXPIRED extends VerificationStatus("02")
    case object FAILED extends VerificationStatus("03")
    case object MISSING extends VerificationStatus("04")
    case object RETRIED_EXCEEDED extends VerificationStatus("05")

    val mapping = VerificationStatus.valuesToEntriesMap.map(_.swap)
  }

  val statusCodec: Codec[VerificationStatus] = LLVAR(
    mappedEnum(AN, VerificationStatus.mapping)
  )
  val codec = statusCodec.as[ActivationResultVerification460109]
}
