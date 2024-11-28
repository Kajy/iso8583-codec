package codec.types.field48.types

import codec.FieldCodecs.LLVAR_AN
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class MerchantId4832(id: String) extends PrivateData48XX

object MerchantId4832 {
  val codec: Codec[MerchantId4832] = LLVAR_AN.as[MerchantId4832]
}
