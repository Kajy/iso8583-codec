package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

case class LocalMerchantCategoryCode4831(categoryCode: String) extends PrivateData48XX

object LocalMerchantCategoryCode4831 {
  val codec: Codec[LocalMerchantCategoryCode4831] = LLVAR_N.as[LocalMerchantCategoryCode4831]
}
