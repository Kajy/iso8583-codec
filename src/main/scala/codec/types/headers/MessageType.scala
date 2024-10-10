package codec

import enumeratum.{Enum, EnumEntry}
import scodec.bits.{ByteVector, HexStringSyntax}
import scodec.codecs.{bytes, mappedEnum}

sealed abstract class MessageType extends EnumEntry

object MessageType extends Enum[MessageType] {

  val values = findValues

  case object AUTHORIZATION_REQUEST extends MessageType
  case object AUTHORIZATION_REQUEST_REPEAT extends MessageType
  case object AUTHORIZATION_REQUEST_RESPONSE extends MessageType
  case object AUTHORIZATION_ADVICE extends MessageType
  case object AUTHORIZATION_ADVICE_REPEAT extends MessageType
  case object AUTHORIZATION_ADVICE_RESPONSE extends MessageType
  case object REVERSAL_REQUEST extends MessageType
  case object REVERSAL_REQUEST_REPEAT extends MessageType
  case object REVERSAL_REQUEST_RESPONSE extends MessageType

  val hexMapping: Map[MessageType, ByteVector] = Map(
    MessageType.AUTHORIZATION_REQUEST -> hex"0x0100",
    MessageType.AUTHORIZATION_REQUEST_REPEAT -> hex"0x0101",
    MessageType.AUTHORIZATION_REQUEST_RESPONSE -> hex"0x0110",
    MessageType.AUTHORIZATION_ADVICE -> hex"0x0120",
    MessageType.AUTHORIZATION_ADVICE_REPEAT -> hex"0x0121",
    MessageType.AUTHORIZATION_ADVICE_RESPONSE -> hex"0x0130",
    MessageType.REVERSAL_REQUEST -> hex"0x0400",
    MessageType.REVERSAL_REQUEST_REPEAT -> hex"0x0401",
    MessageType.REVERSAL_REQUEST_RESPONSE -> hex"0x0410"
  )

  val codec = mappedEnum(bytes(2), MessageType.hexMapping)
}
