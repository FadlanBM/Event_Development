<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Person;
use App\Models\User;
use Illuminate\Contracts\Cache\Store;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Facades\Validator;
use Tests\Helper;

class AuthController extends Controller
{
    use Helper;
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
                if ($user->image!=null) {
                    $lamas= $request->image->storeAs('public/user',$user->image);
                    Storage::delete($lamas);
                }
                $image=$request->image->getClientOriginalName();
                $image=str_replace(' ','',$image);
                $image=date('Hs').rand(1,999)."_".$image;
                $filename=$image;
               $lamas= $request->image->storeAs('public/user',$image);
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

    public function destroy($id){
        $users=User::where('id',$id)->first();
        if ($users) {
            $person=Person::where('users_id',$users->id);
            if ($person) {
                $person->delete();
                $users->delete();
                return $this->valid_200("Berhasil delete account",$users);
            }else {
                $users->delete();
                return $this->valid_200("Berhasil delete account",$users);
            }
        }else {
            return $this->error_400("terjadi Kegalaan");
        }
    }

    public function getPass(Request $request,$id){
        $user=User::where('id',$id)->first();
        if ($user) {
            if (password_verify($request->passwordOld,$user->password)) {
                return $this->valid_200("Password Benar",$user);
            }else {
                return $this->error_400("Password salah");
            }
        }else {
            return $this->error_400("email tidak di temukan");
        }
    }
}
