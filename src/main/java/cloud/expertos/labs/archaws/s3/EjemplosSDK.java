package cloud.expertos.labs.archaws.s3;

import java.util.List;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.Region;

public class EjemplosSDK {

	/* Credenciales estblecidas programáticamente */
	/*
	BasicAWSCredentials awsCreds = new BasicAWSCredentials("access_key_id", "secret_key_id");
	AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
	                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
	                        .build();
	*/

	/* Para establecer credenciales desde Java existen múltiples opciones.
	 * https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html
	 */

	private final static AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();

	public static void main(String[] args) {

			listarBuckets();

		//Bucket res = crearBucket("nombre-bucket-321");
		//System.out.println("Creado bucket " + res);

		//eliminarBucket("nombre-bucket");

	}

	private static void eliminarBucket(String bucketName) {
		try {
			System.out.println(String.format("Borrando bucket '%s' ", bucketName));
			s3.deleteBucket(bucketName);
			System.out.println("Bucket borrado");
		} catch (AmazonS3Exception e) {
			System.err.println(e.getErrorMessage());
		}

	}

	private static void listarBuckets() {
		final List<Bucket> buckets = s3.listBuckets();

		System.out.println("Hallados un total de: " + buckets.size());

		buckets.forEach(System.out::println);

	}

	public static Bucket crearBucket(String bucketName) {
		Bucket res = null;
		if (s3.doesBucketExistV2(bucketName)) {
			System.err.println(String.format("Bucket '%s' existente", bucketName));
			res = buscarBucket(bucketName);
		} else {
			try {
				System.out.println(String.format("Bucket '%s' inexistente, creando...", bucketName));
				res = s3.createBucket(new CreateBucketRequest(bucketName, Region.EU_Ireland));
			} catch (AmazonS3Exception e) {
				System.err.println(e.getErrorMessage());
			}
		}
		return res;
	}

	public static Bucket buscarBucket(String bucketName) {
		Bucket res = null;
		final List<Bucket> buckets = s3.listBuckets();
		for (final Bucket b : buckets) {
			if (b.getName().equals(bucketName)) {
				res = b;
			}
		}
		return res;
	}

}
