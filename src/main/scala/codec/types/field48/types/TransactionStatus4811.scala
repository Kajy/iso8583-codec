package codec.types.field48.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field48.PrivateData48XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.codecs.*
import scodec.{Codec, TransformSyntax}

case class TransactionStatus4811(status: TransactionStatus4811.Status) extends PrivateData48XX

object TransactionStatus4811 {
  sealed abstract class Status(val value: String) extends StringEnumEntry

  object Status extends StringEnum[Status] {
    val values = findValues

    case object NORMAL              extends Status("00")
    case object PREAUTHORIZATION    extends Status("01")
    case object INFORMATION_REQUEST extends Status("02")

    val mapping = Status.valuesToEntriesMap.map(_.swap)
    val codec   = "Status" | mappedEnum(N, mapping)
  }

  val codec: Codec[TransactionStatus4811] = LLVAR_N(Status.codec).as[TransactionStatus4811]
}
