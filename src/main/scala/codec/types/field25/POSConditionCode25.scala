package codec.types

import codec.FieldCodecs.N
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.Codec
import scodec.codecs.mappedEnum

sealed abstract class POSConditionCode25(val value: String)
    extends StringEnumEntry

object POSConditionCode25 extends StringEnum[POSConditionCode25] {

  val values = findValues

  case object STANDARD extends POSConditionCode25("00")
  case object CARDHOLDER_NOT_PRESENT extends POSConditionCode25("01")
  case object SELF_SERVICE_TERMINAL_CAN_STORE extends POSConditionCode25("02")
  case object SUSPICION_FRAUD_BY_MERCHANT extends POSConditionCode25("03")
  case object CARDHOLDER_PRESENT_CARD_NOT_PRESENT
      extends POSConditionCode25("05")
  case object PHONE_REQUEST extends POSConditionCode25("07")
  case object MAIL_OR_PHONE_ORDER extends POSConditionCode25("08")
  case object CARDHOLDER_ID_VERIFIED extends POSConditionCode25("10")
  case object SUSPICION_FRAUD extends POSConditionCode25("11")
  case object SAFETY_REASONS extends POSConditionCode25("12")
  case object HOME_TERMINAL extends POSConditionCode25("15")
  case object SELF_SERVICE_TERMINAL_CANNOT_STORE
      extends POSConditionCode25("27")
  case object CARD_VALIDITY_CHECK extends POSConditionCode25("51")

  val codec: Codec[POSConditionCode25] =
    mappedEnum(N(2), POSConditionCode25.valuesToEntriesMap.map(_.swap))
}
