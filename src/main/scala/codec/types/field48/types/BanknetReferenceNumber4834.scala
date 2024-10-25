package codec.types.field48.types

import codec.FieldCodecs.LLVAR_AN
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class BanknetReferenceNumber4834(number: String) extends PrivateData48XX

object BanknetReferenceNumber4834 {
  val codec: Codec[BanknetReferenceNumber4834] = LLVAR_AN.as[BanknetReferenceNumber4834]
}
