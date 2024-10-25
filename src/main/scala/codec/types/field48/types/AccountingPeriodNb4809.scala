package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class AccountingPeriodNb4809(value: String) extends PrivateData48XX

object AccountingPeriodNb4809 {
  val codec: Codec[AccountingPeriodNb4809] = LLVAR_N.as[AccountingPeriodNb4809]
}
