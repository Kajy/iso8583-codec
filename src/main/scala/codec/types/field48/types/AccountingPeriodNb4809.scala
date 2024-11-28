package codec.types.field48.types

import codec.FieldCodecs.TLV_N
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class AccountingPeriodNb4809(periodNb: Long) extends PrivateData48XX

object AccountingPeriodNb4809 {
  val codec: Codec[AccountingPeriodNb4809] = TLV_N(4).as[AccountingPeriodNb4809]
}
