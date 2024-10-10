package codec.types.field48.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field48.PrivateData48XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.Codec
import scodec.codecs._

case class OperationType4801(code: OperationType4801.OperationType)
    extends PrivateData48XX

object OperationType4801 {
  sealed abstract class OperationType(val value: String) extends StringEnumEntry

  object OperationType extends StringEnum[OperationType] {
    val values = findValues

    case object CREDIT extends OperationType("00")
    case object DEBIT extends OperationType("01")

    val mapping = OperationType.valuesToEntriesMap.map(_.swap)
    val codec = "OperationType" | mappedEnum(N, mapping)
  }
  val codec: Codec[OperationType4801] =
    LLVAR_N(OperationType.codec).as[OperationType4801]
}
