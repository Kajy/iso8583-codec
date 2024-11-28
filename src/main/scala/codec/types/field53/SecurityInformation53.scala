package codec.types.field53

import codec.FieldCodecs.LLVAR_HEX
import scodec.{ Codec, TransformSyntax }
import scodec.bits.ByteVector

case class SecurityInformation53(hexValue: ByteVector)

object SecurityInformation53 {
  // No more information for subfields in documentation
  val codec: Codec[SecurityInformation53] = LLVAR_HEX.as[SecurityInformation53]
}
