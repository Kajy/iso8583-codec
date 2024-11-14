package codec.types.field46.field1.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field46.field1.TokenData4601XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.codecs.mappedEnum
import scodec.{Codec, TransformSyntax}

case class MessageReasonCode460111(code: MessageReasonCode460111.ReasonCode)
    extends TokenData4601XX

object MessageReasonCode460111 {
  sealed abstract class ReasonCode(val value: String) extends StringEnumEntry

  object ReasonCode extends StringEnum[ReasonCode] {
    val values: IndexedSeq[ReasonCode] = findValues

    case object TOKEN_CREATED extends ReasonCode("3700")
    case object TOKEN_DESACTIVATED extends ReasonCode("3701")
    case object TOKEN_SUSPENDED extends ReasonCode("3702")
    case object TOKEN_RESUME extends ReasonCode("3703")
    case object DEVICE_PROVISIONING_RESULT extends ReasonCode("3711")
    case object OTP_VERIFICATION_RESULT extends ReasonCode("3712")
    case object CALL_CENTER_ACTIVATION extends ReasonCode("3713")
    case object MOBILE_BANKING_APP_ACTIVATION extends ReasonCode("3714")
    case object REPLENISHMENT_CONFIRMATION extends ReasonCode("3715")
    case object TOKEN_EXPIRY_UPDATE extends ReasonCode("3716")
    case object PAN_EXPIRY_UPDATE extends ReasonCode("3720")
    case object PAN_UPDATE extends ReasonCode("3721")
    case object DEVICE_PROVISIONING_UPDATE_RESULT extends ReasonCode("3730")

    val mapping = ReasonCode.valuesToEntriesMap.map(_.swap)
  }

  val statusCodec: Codec[ReasonCode] = LLVAR_N(
    mappedEnum(N, ReasonCode.mapping)
  )
  val codec = statusCodec.as[MessageReasonCode460111]
}
