<?php
Namespace Tests;

use Illuminate\Http\JsonResponse;

trait Helper
{
    private function error_400($message):JsonResponse{
        return response()->json([
            'message'=>$message,
            'code'=>400
        ],400);
    }

    private function valid_200($message="SUCCESS",$data):JsonResponse{
        return response()->json([
            'message'=>$message,
            'data'=>$data,
            'code'=>200
        ],200);
    }
}
