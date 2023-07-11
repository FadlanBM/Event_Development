<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;

class AuthController extends Controller
{
    public function register(Request $request){
        $validasi=Validator::make($request->all(),[
            'name'=>'required',
            'email'=>'required|unique:users',
            'password'=>'required'
        ]);

        if ($validasi->fails()) {
            return $this->error_400($validasi->errors()->all());
        }

        $user=User::create($request->all());

        if ($user) {
            return $this->valid_200('Berhasil register',$user);
        }else{
            return $this->error_400("Terjadi Kesalahan");
        }
    }

    public function update(Request $request, $id){    

        $user=User::where('id',$id)->first();
        if ($user) {
            $user->update($request->all());
            return $this->valid_200("Success",$user);
        }
        return $this->error_400("Gagal Update");

    }

    public function login(Request $request){    
        $validasi=Validator::make($request->all(),[
            'email'=>'required',
            'password'=>'required'
        ]);

        if ($validasi->fails()) {
            return $this->error_400($validasi->errors()->all());
        }
        $user=User::where('email',$request->email)->first();
        if ($user) {
            if (password_verify($request->password,$user->password)) {
                return $this->valid_200("Selamat datang $user->name",$user);
            }
            else{
                return $this->error_400("Passowd salah");
            }
        }else{
            return $this->error_400("Email Tidak di temukan");
        }

    }

    public function upload(Request $request, $id){
        $user=User::where('id',$id)->first();
        if ($user) {
            $filename="";
            if ($request->image) {
                $image=$request->image->getClientOriginalName();
                $image=str_replace(' ','',$image);
                $image=date('Hs').rand(1,999)."_".$image;
                $filename=$image;
                $request->image->storeAs('public/user',$image);
                $user->update([
                    'image'=>$filename
                ]);
                return $this->valid_200("Berhasil",$user);
            }else {
                return $this->error_400("harus kirim image");     
            }
        }else {
            return $this->error_400("Terjadi Kesalahan");
        }

    }

    private function error_400($message){
        return response()->json([
            'message'=>$message,
            'code'=>400
        ],400);
    }

    private function valid_200($message="SUCCESS",$data){
        return response()->json([
            'message'=>$message,
            'data'=>$data,
            'code'=>200
        ],200);
    }
}
