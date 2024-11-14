package codec.types.field39

import codec.FieldCodecs.AN
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.Codec
import scodec.codecs.mappedEnum

sealed abstract class ResponseCode39(val value: String) extends StringEnumEntry

object ResponseCode39 extends StringEnum[ResponseCode39] {

  val values = findValues

  case object APPROVED extends ResponseCode39("00")
  case object INVALID_MERCHANT extends ResponseCode39("03")
  case object PICK_UP extends ResponseCode39("04")
  case object DO_NOT_HONOR extends ResponseCode39("05")
  case object HONOR_WITH_IDENTIFICATION extends ResponseCode39("08")
  case object PARTIALLY_AUTHORIZED extends ResponseCode39("10")
  case object INVALID_TRANSACTION extends ResponseCode39("12")
  case object INVALID_AMOUNT extends ResponseCode39("13")
  case object INVALID_CARDHOLDER_NB extends ResponseCode39("14")
  case object NO_SUCH_ISSUER extends ResponseCode39("15")
  case object ISSUER_CANCELLATION extends ResponseCode39("17")
  case object UNABLE_LOCATE_RECORD_ON_FILE extends ResponseCode39("25")
  case object FILE_UPDATE_FIELD_EDIT_ERROR extends ResponseCode39("27")
  case object FORMAT_ERROR extends ResponseCode39("30")
  case object PARTIAL_CANCELLATION extends ResponseCode39("32")
  case object LOST_CARD extends ResponseCode39("41")
  case object STOLEN_CARD extends ResponseCode39("43")
  case object INSUFFICIENT_FUNDS extends ResponseCode39("51")
  case object ACCOUNT_DOES_NOT_EXIST extends ResponseCode39("52")
  case object EXPIRED_CARD extends ResponseCode39("54")
  case object INCORRECT_PIN extends ResponseCode39("55")
  case object TRANSACTION_NOT_ALLOWED_CARDHOLDER extends ResponseCode39("57")
  case object TRANSACTION_NOT_PERMITTED_ACQUIRER extends ResponseCode39("58")
  case object ATM_AMOUNT_LIMIT_EXCEEDED extends ResponseCode39("61")
  case object CARD_CANCELLED extends ResponseCode39("62")
  case object SECURITY_VIOLATION extends ResponseCode39("63")
  case object ATM_FREQUENCY_LIMIT_EXCEEDED extends ResponseCode39("65")
  case object RESPONSE_TOO_LATE extends ResponseCode39("68")
  case object PIN_NOT_CHANGED extends ResponseCode39("71")
  case object PIN_TRIES_EXCEEDED extends ResponseCode39("75")
  case object INVALID_TARGET_ACCOUNT extends ResponseCode39("76")
  case object INVALID_SOURCE_ACCOUNT extends ResponseCode39("77")
  case object SPECIFIED_ACCOUNT_DISABLED extends ResponseCode39("78")
  case object VKEY_VALIDATION_FAILED extends ResponseCode39("79")
  case object DOMESTIC_DEBIT_NOT_PERMITTED extends ResponseCode39("81")
  case object NO_REASON_TO_DECLINE extends ResponseCode39("85")
  case object PIN_CODE_VALIDATION_NOT_POSSIBLE extends ResponseCode39("86")
  case object CASHBACK_TRANSACTION_ONLY_PURCHASE extends ResponseCode39("87")
  case object CRYPTOGRAPHIC_FAILURE extends ResponseCode39("88")
  case object PIN_BLOC_FORMAT_INVALIDE extends ResponseCode39("89")
  case object ISSUER_IS_INOPERATIVE extends ResponseCode39("91")
  case object TRANSACTION_ROUTING_NOT_POSSIBLE extends ResponseCode39("92")
  case object DUPLICATE_TRANSACTION extends ResponseCode39("94")
  case object SYSTEM_MALFUNCTION extends ResponseCode39("96")
  case object SERVER_UNAVAILABLE extends ResponseCode39("98")
  case object TRANSACTION_CURRENCY_INCORRECT extends ResponseCode39("P5")
  case object CARD_OUT_OF_ORDER extends ResponseCode39("SA")
  case object ACCOUNT_BLOCKED_CLOSED extends ResponseCode39("SD")
  case object WRONG_DEBIT_ACCOUNT extends ResponseCode39("SE")
  case object AMOUNT_NOT_SUPPORTED extends ResponseCode39("Z5")

  val codec: Codec[ResponseCode39] =
    mappedEnum(AN(2), ResponseCode39.valuesToEntriesMap.map(_.swap))
}
