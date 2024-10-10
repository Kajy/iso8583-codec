package codec.types.field48.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field48.PrivateData48XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.{Codec, TransformSyntax}
import scodec.codecs.*

case class TransactionEnvType4803(`type`: TransactionEnvType4803.EnvType) extends PrivateData48XX

object TransactionEnvType4803 {
  sealed abstract class EnvType(val value: String) extends StringEnumEntry

  object EnvType extends StringEnum[EnvType] {
    val values = findValues

    case object PROXIMITY_EVENT                    extends EnvType("01")
    case object VAD                                extends EnvType("02")
    case object VADS                               extends EnvType("03")
    case object WITHDRAWAL                         extends EnvType("04")
    case object FUNDS_TRANSFER_MAIL_ORDER          extends EnvType("B0")
    case object FUNDS_TRANSFER_INTERNET            extends EnvType("B1")
    case object FUNDS_TRANSFER_FACE_TO_FACE        extends EnvType("B2")
    case object FUNDS_TRANSFER_UNATTENDED_TERMINAL extends EnvType("B3")
    case object OTHER                              extends EnvType("99")

    val mapping = EnvType.valuesToEntriesMap.map(_.swap)
    val codec   = "OperationType" | mappedEnum(N, mapping)
  }

  val codec: Codec[TransactionEnvType4803] =
    LLVAR_N(EnvType.codec).as[TransactionEnvType4803]

}
